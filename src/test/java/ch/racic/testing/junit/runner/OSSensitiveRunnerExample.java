/*
 * Copyleft (c) 2014. This code is for learning purposes only. Do whatever you like with it but don't take it as perfect code.
 * This code lab has been developed by Michel Racic (http://rac.su/+) and funded partially by Credit Suisse AG (http://www.credit-suisse.ch) and GDG Zürich (http://www.gdgzh.ch).
 */

package ch.racic.testing.junit.runner;

import ch.racic.testing.annotation.TargetOS;
import org.apache.commons.exec.OS;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by rac on 14.06.14.
 */
@RunWith(OSSensitiveRunner.class)
public class OSSensitiveRunnerExample {

    @Test
    @TargetOS(family = "mac")
    public void runOnlyOnMac() {
        Assert.assertTrue("Test did execute on Mac", OS.isFamilyMac());
    }

    @Test
    @TargetOS(family = "windows")
    public void runOnlyOnWindows() {
        Assert.assertTrue("Test did execute on Windows", OS.isFamilyWindows());
    }

}
