/*
 * Copyright (c) 2016-2017, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.tinydb.maven;

import static com.github.tonivade.tinydb.maven.TinyDBMojo.TINYDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import com.github.tonivade.tinydb.TinyDB;

@Mojo(name = "stop", defaultPhase = LifecyclePhase.NONE)
public class StopTinyDBMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        TinyDB tinyDB = (TinyDB) getPluginContext().get(TINYDB_SERVER);

        if (tinyDB != null) {
            getLog().info("stopping tinydb server");
            tinyDB.stop();
        } else {
            getLog().warn("no server found");
        }
    }
}
