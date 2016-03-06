/*
 * Copyright (c) 2016, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.tinydb.maven;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import tonivade.db.TinyDB;

public class StopTinyDBMojoTest extends AbstractMojoTestCase {

    public void testExecute() throws Exception {
        File pom = getTestFile("src/test/resources/test-pom.xml");

        StopTinyDBMojo stop = (StopTinyDBMojo) lookupMojo("stop", pom);

        TinyDB tinyDB = mock(TinyDB.class);
        stop.setPluginContext(new HashMap<>());
        stop.getPluginContext().put(TinyDBMojo.TINYDB_SERVER, tinyDB);

        stop.execute();

        verify(tinyDB).stop();
    }

}
