/*
 * Copyright (c) 2016, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.tinydb.maven;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class RunTinyDBMojoTest extends AbstractMojoTestCase {

    public void testExecute() throws Exception {
        File pom = getTestFile("src/test/resources/test-pom.xml");

        RunTinyDBMojo run = (RunTinyDBMojo) lookupMojo("run", pom);

        run.setPort(12345);;
        run.setPluginContext(new HashMap<>());
        run.execute();

        assertNotNull(run.getPluginContext().get(TinyDBMojo.TINYDB_SERVER));
    }
}
