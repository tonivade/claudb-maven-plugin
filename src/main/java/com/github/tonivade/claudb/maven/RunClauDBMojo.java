/*
 * Copyright (c) 2016-2024, Antonio Gabriel Muñoz Conejo <me at tonivade dot es>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import static com.github.tonivade.claudb.maven.ClauDBMojo.CLAUDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.github.tonivade.claudb.ClauDB;
import com.github.tonivade.resp.RespServer;

@Mojo(name = "run", defaultPhase = LifecyclePhase.NONE)
public class RunClauDBMojo extends AbstractMojo {

  @Parameter(property = "claudb.port", defaultValue = "7081")
  private Integer port;

  public void setPort(Integer port) {
    this.port = port;
  }

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    getLog().info("Starting claudb server at port: " + port);

    RespServer server = ClauDB.builder().port(port).build();
    server.start();

    getPluginContext().put(CLAUDB_SERVER, server);
  }
}
