/*
 * Copyright (c) 2016-2017, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.claudb.maven;

import static com.github.tonivade.claudb.maven.ClauDBMojo.CLAUDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import com.github.tonivade.claudb.ClauDB;

@Mojo(name = "stop", defaultPhase = LifecyclePhase.NONE)
public class StopClauDBMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        ClauDB claudb = (ClauDB) getPluginContext().get(CLAUDB_SERVER);

        if (claudb != null) {
            getLog().info("Stopping claudb server");
            claudb.stop();
        } else {
            getLog().warn("no server found");
        }
    }
}
