/*
 * Copyright (c) 2016-2017, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import com.github.tonivade.claudb.ClauDB;

public class StopClauDBMojoTest extends AbstractMojoTestCase {

    public void testExecute() throws Exception {
        File pom = getTestFile("src/test/resources/test-pom.xml");

        StopClauDBMojo stop = (StopClauDBMojo) lookupMojo("stop", pom);

        ClauDB claudb = mock(ClauDB.class);
        stop.setPluginContext(new HashMap<>());
        stop.getPluginContext().put(ClauDBMojo.CLAUDB_SERVER, claudb);

        stop.execute();

        verify(claudb).stop();
    }
}
