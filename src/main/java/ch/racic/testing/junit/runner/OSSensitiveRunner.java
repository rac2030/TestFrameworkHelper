/*
 * Copyleft (c) 2014. This code is for learning purposes only. Do whatever you like with it but don't take it as perfect code.
 * This code lab has been developed by Michel Racic (http://rac.su/+) and funded partially by Credit Suisse AG (http://www.credit-suisse.ch) and GDG Zürich (http://www.gdgzh.ch).
 */

/*
 * Copyleft (c) 2014. This code is for learning purposes only. Do whatever you like with it but don't take it as perfect code.
 * Michel Racic (http://rac.su/+) => github.com/rac2030
 */

package ch.racic.testing.junit.runner;

import ch.racic.testing.annotation.TargetOS;
import org.apache.commons.exec.OS;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * Created by rac on 14.06.14.
 */
public class OSSensitiveRunner extends BlockJUnit4ClassRunner {
    public OSSensitiveRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        Description description = describeChild(method);
        if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored(description);
        } else if (method.getAnnotation(TargetOS.class) != null) {
            final TargetOS tos = method.getAnnotation(TargetOS.class);
            String name = tos.name().equals("") ? null : tos.name();
            String arch = tos.arch().equals("") ? null : tos.arch();
            String version = tos.version().equals("") ? null : tos.version();
            if (OS.isOs(tos.family(), name, arch, version)) {
                runLeaf(methodBlock(method), description, notifier);
            } else {
                notifier.fireTestIgnored(description);
            }
        } else {
            runLeaf(methodBlock(method), description, notifier);
        }
    }

}
