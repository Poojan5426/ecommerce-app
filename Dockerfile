# Base Image
FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH


# Install OS Dependencies
RUN apt-get update && apt-get install -y \
    apache2 \
    openjdk-21-jdk \
    git \
    maven \
    curl \
    ca-certificates \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*


# Install Syft (SBOM tool)
RUN curl -sSfL https://raw.githubusercontent.com/anchore/syft/main/install.sh \
    | sh -s -- -b /usr/local/bin

# Enable Apache Modules
RUN a2enmod proxy proxy_http

# App Directory
WORKDIR /opt/app

# Clone Application Source
# =========================
# REPLACE with your GitHub repo
RUN git clone https://github.com/<YOUR_GITHUB_USERNAME>/<YOUR_REPO>.git .


# Build Spring Boot App
RUN mvn clean package -DskipTests

# Generate SBOM (CycloneDX format)
RUN syft dir:/opt/app \
    -o cyclonedx-json \
    > /opt/app/sbom-cyclonedx.json

# Expose Ports
EXPOSE 80 8080


# Start Apache + Spring Boot
CMD service apache2 start && \
    java -jar target/*.jar
