/*
 * Copyright (c) 2016, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.tinydb.maven;

import static tonivade.tinydb.maven.TinyDBMojo.TINYDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import tonivade.db.TinyDB;

@Mojo(name = "run", defaultPhase = LifecyclePhase.NONE)
public class RunTinyDBMojo extends AbstractMojo {

    @Parameter(property = "tinydb.port", defaultValue = "7081")
    private Integer port;

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Starting redis server at port: " + port);

        TinyDB tinyDB = new TinyDB("localhost", port);
        tinyDB.start();

        getPluginContext().put(TINYDB_SERVER, tinyDB);
    }

}
