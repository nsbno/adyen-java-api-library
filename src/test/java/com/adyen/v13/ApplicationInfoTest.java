package com.adyen.v13;

import com.adyen.v13.model.applicationinfo.ApplicationInfo;
import org.junit.Test;

import static com.adyen.v13.Client.LIB_NAME;
import static com.adyen.v13.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApplicationInfoTest {

    @Test
    public void TestApplicationInfoEquals() {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        ApplicationInfo applicationInfo2 = new ApplicationInfo();

        assertEquals(applicationInfo, applicationInfo2);
    }

    @Test
    public void TestApplicationInfoPrefilledLibraryFields() {
        ApplicationInfo applicationInfo = new ApplicationInfo();

        assertNotNull(applicationInfo.getAdyenLibrary());
        assertNotNull(applicationInfo.getAdyenLibrary().getName());
        assertEquals(LIB_NAME, applicationInfo.getAdyenLibrary().getName());
        assertNotNull(applicationInfo.getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, applicationInfo.getAdyenLibrary().getVersion());
    }
}
