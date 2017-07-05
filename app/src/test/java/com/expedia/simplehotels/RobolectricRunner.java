package com.expedia.simplehotels;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;
import org.robolectric.res.FsFile;

/**
 * Created by paulkite on 7/2/17.
 */

public class RobolectricRunner extends RobolectricTestRunner {
    public RobolectricRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected final AndroidManifest getAppManifest(Config config) {
        String buildVariant = (BuildConfig.FLAVOR.isEmpty() ? "" : BuildConfig.FLAVOR + "/") + BuildConfig.BUILD_TYPE;
        String appId = BuildConfig.APPLICATION_ID;

        FsFile mani = Fs.fileFromPath("app/build/intermediates/manifests/full/" + buildVariant + "/AndroidManifest.xml");
        FsFile res = Fs.fileFromPath("app/build/intermediates/res/merged/" + buildVariant);
        FsFile assets = Fs.fileFromPath("app/build/intermediates/assets/" + buildVariant);

        return new AndroidManifest(mani, res, assets, appId);
    }
}
