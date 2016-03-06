# TinyDB Maven Plugin

This is a maven plugin to run a TinyDB server. It can be used to integration
test with redis aplications.

## Usage

```
<plugins>
    <plugin>
        <groupId>tonivade</groupId>
        <artifactId>tinydb-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>tinydb-run</id>
                <phase>pre-integration-test</phase>
                <goals>
                    <goal>run</goal>
                </goals>
                <configuration>
                    <port>6379</port>
                </configuration>
            </execution>
            <execution>
                <id>tinydb-stop</id>
                <phase>post-integration-test</phase>
                <goals>
                    <goal>stop</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
</plugins>
```

## License

Licensed under MIT License