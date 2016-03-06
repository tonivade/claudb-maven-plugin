package tonivade.tinydb.maven;

import static tonivade.tinydb.maven.TinyDBMojo.TINYDB_SERVER;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import tonivade.db.TinyDB;

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
