# ClauDB Maven Plugin

This is a maven plugin to run a ClauDB server. It can be used to integration
test with redis aplications.

ClauDB is a REDIS implementation in Java. It supports many of the REDIS commands. 
ClauDB can run standalone of embeded inside your application, so, this is why 
you can run as a maven plugin.

## Usage

```
<plugins>
    <plugin>
        <groupId>com.github.tonivade</groupId>
        <artifactId>claudb-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>claudb-run</id>
                <phase>pre-integration-test</phase>
                <goals>
                    <goal>run</goal>
                </goals>
                <configuration>
                    <port>6379</port>
                </configuration>
            </execution>
            <execution>
                <id>claudb-stop</id>
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
