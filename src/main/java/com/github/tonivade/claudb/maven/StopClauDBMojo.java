/*
 * Copyright (c) 2016-2025, Antonio Gabriel Muñoz Conejo <me at tonivade dot es>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import static com.github.tonivade.claudb.maven.ClauDBMojo.CLAUDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import com.github.tonivade.resp.RespServer;

@Mojo(name = "stop", defaultPhase = LifecyclePhase.NONE)
public class StopClauDBMojo extends AbstractMojo {

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    RespServer server = (RespServer) getPluginContext().get(CLAUDB_SERVER);

    if (server != null) {
      getLog().info("Stopping claudb server");
      server.stop();
    } else {
      getLog().warn("no server found");
    }
  }
}
