# Maven Multi-Module Blueprint (MMM)

See this [blogpost](https://bwgjoseph.com/mastering-gitlab-parent-child-pipelines-scalable-ci-for-multi-module-maven-monorepos) for detailed explanation

## Purpose
An **Architectural Blueprint** for scalable, high-performance Java projects. This repository validates Maven multi-module orchestration, dependency inheritance, and production-grade CI/CD patterns.

## Key Architectural Features
- **Tiered Aggregation**: A robust root orchestration strategy with a centralized `parent-pom` for consistent dependency and plugin management.
- **Security-First Pipeline**: Integrated automated **SAST** and **Secret Detection** using standardized GitLab templates.
- **High-Performance CI/CD**: A Parent-Child pipeline architecture leveraging `strategy: depend` for DAG-based scheduling and ID-based artifact aggregation.
- **Containerization**: Optimized `jib-maven-plugin` configuration for daemonless, efficient image generation pushed directly to the GitLab Registry.
- **Quality Assurance**: Automated aggregate coverage reporting (JaCoCo) and module-isolated SonarQube analysis.
- **Modern Standards**: Fully configured for **Java 25**, featuring comprehensive JaCoCo aggregate coverage reporting.

## Getting Started

### Prerequisites
- **Java 25**
- **Maven 3.9+** (or use the provided `./mvnw` wrapper)

### Quick Start
To build the entire project:
```bash
./mvnw clean install
```

To run a specific module (e.g., `mmm-core`):
```bash
./mvnw spring-boot:run -f project -pl mmm-core -am
```
*Note: The `-am` (also-make) flag automatically builds dependent modules (like `mmm-security`).*
