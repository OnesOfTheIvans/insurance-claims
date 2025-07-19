# Insurance Claims Processing Engine

This project implements a modular engine for processing insurance claims, created as a technical assignment.

## Project Structure

```
insurance-claims/
├── claim_processor/         # Main Maven project
│   ├── pom.xml              # Maven build file
│   ├── src/                 # Java source code
│   ├── target/              # Compiled output
│   └── ...                  # Other Maven files
├── claims_1.csv             # Example input data
├── Zadanie_rekrutacyjne_-_silnik_rozszczen_ubezpieczeniowych.pdf  # Assignment spec (PL)
├── .gitignore
└── ...
```

## Getting Started

### Prerequisites

- Java 21 or newer
- Maven 3.6+ 

### Build the Project

Go to the `claim_processor` directory and build using Maven:

```bash
cd insurance-claims/claim_processor
mvn clean install
```

### Running

By default, this is a Java application packaged as a JAR.  
To run, use:

```bash
java -jar target/claim_processor-1.0-SNAPSHOT.jar
```

### Example Input

- `claims_1.csv` — Example input claims file.
- You can place your own CSV in the project root or adjust the path in the code.

## Configuration

- Input file path and other settings can be configured in the code (see `src/main/java/org/example/Main.java` or similar).

## Dependencies

- [OpenCSV](https://opencsv.sourceforge.net/) for CSV parsing
- [SLF4J](http://www.slf4j.org/) for logging

All dependencies are managed via Maven (`pom.xml`).

## Development

To open in IntelliJ IDEA or other IDE, import as a Maven project from the `claim_processor` directory.

**Assignment PDF:**  
See `Zadanie_rekrutacyjne_-_silnik_rozszczen_ubezpieczeniowych.pdf` for the original problem description (in Polish).