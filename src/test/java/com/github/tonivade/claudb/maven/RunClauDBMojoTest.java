/*
 * Copyright (c) 2016-2024, Antonio Gabriel Muñoz Conejo <me at tonivade dot es>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class RunClauDBMojoTest extends AbstractMojoTestCase {

  public void testExecute() throws Exception {
    File pom = getTestFile("src/test/resources/test-pom.xml");

    RunClauDBMojo run = (RunClauDBMojo) lookupMojo("run", pom);

    run.setPort(12345);
    run.setPluginContext(new HashMap<>());
    run.execute();

    assertNotNull(run.getPluginContext().get(ClauDBMojo.CLAUDB_SERVER));
  }
}
