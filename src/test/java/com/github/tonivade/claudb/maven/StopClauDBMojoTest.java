/*
 * Copyright (c) 2016-2020, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import com.github.tonivade.resp.RespServer;

public class StopClauDBMojoTest extends AbstractMojoTestCase {

  public void testExecute() throws Exception {
    File pom = getTestFile("src/test/resources/test-pom.xml");

    StopClauDBMojo stop = (StopClauDBMojo) lookupMojo("stop", pom);

    RespServer server = mock(RespServer.class);
    stop.setPluginContext(new HashMap<>());
    stop.getPluginContext().put(ClauDBMojo.CLAUDB_SERVER, server);

    stop.execute();

    verify(server).stop();
  }
}
