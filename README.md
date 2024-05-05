# spring-common

## How to make artifact and upload to github package
### add config below to `./m2/settings.xml`
```xml
  <servers>
    <server>
      <id>github</id>
      <username>{USERNAME}</username>
      <password>{GITHUB_TOKEN}</password>
    </server>
  </servers>
```

### add config below to `pom.xml`
```xml
  <repositories>
    <repository>
       <id>central</id>
       <url>https://repo1.maven.org/maven2</url>
    </repository>
    <repository>
       <id>github</id>
       <url>https://maven.pkg.github.com/{USERNAME}/{REPOSITORY}</url>
       <snapshots>
          <enabled>true</enabled>
       </snapshots>
    </repository>
  </repositories>
```

### use command below 
```bash
mvn deploy
```

## How to make artifact and install on local machine
### use command below
```bash
mvn clean install
```

## How to use artifact in other spring boot project
### add dependency to `pom.xml`
```xml
<dependency>
    <groupId>com.thanabodee2661</groupId>
    <artifactId>spring-common</artifactId>
    <version>{APP_VERSION}</version>
</dependency>
```
### and add config repository to `pom.xml`
```xml
<repositories>
    <repository>
        <id>central</id>
        <url>https://repo1.maven.org/maven2</url>
    </repository>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/thanabodee2661/spring-common</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```