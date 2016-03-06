# TinyDB Maven Plugin

This is a maven plugin to run a TinyDB server. It can be used to integration
test with redis aplications.

## Usage

```
&lt;plugins&gt;
    &lt;plugin&gt;
        &lt;groupId&gt;tonivade&lt;/groupId&gt;
        &lt;artifactId&gt;tinydb-maven-plugin&lt;/artifactId&gt;
        &lt;executions&gt;
            &lt;execution&gt;
                &lt;id&gt;tinydb-run&lt;/id&gt;
                &lt;phase&gt;pre-integration-test&lt;/phase&gt;
                &lt;goals&gt;
                    &lt;goal&gt;run&lt;/goal&gt;
                &lt;/goals&gt;
                &lt;configuration&gt;
                    &lt;port&gt;6379&lt;/port&gt;
                &lt;/configuration&gt;
            &lt;/execution&gt;
            &lt;execution&gt;
                &lt;id&gt;tinydb-stop&lt;/id&gt;
                &lt;phase&gt;post-integration-test&lt;/phase&gt;
                &lt;goals&gt;
                    &lt;goal&gt;stop&lt;/goal&gt;
                &lt;/goals&gt;
            &lt;/execution&gt;
        &lt;/executions&gt;
    &lt;/plugin&gt;
&lt;/plugins&gt;
```

## License

Licensed under MIT License