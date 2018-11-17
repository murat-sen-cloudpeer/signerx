package com.gelece.signer.utils;

import com.gelecex.signer.exception.GelecexSignerException;
import com.gelecex.signer.utils.TubitakSettingsUploader;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.gov.tubitak.uekae.esya.api.common.util.LicenseUtil;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by obetron on 17.11.2018
 */
public class TubitakSettingsUploaderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TubitakSettingsUploaderTest.class);

    @Test
    public void licenseFileReaderTest() {
        try {
            Method licenseFileReaderMethod = TubitakSettingsUploader.class.getDeclaredMethod("licenseFileReader", null);
            licenseFileReaderMethod.setAccessible(true);
            InputStream inStream = (InputStream)licenseFileReaderMethod.invoke(null);
            Assert.assertNotNull(inStream);
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
        } catch (InvocationTargetException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
        }
    }

    @Test
    public void licenseFileUploader() {
        try {
            TubitakSettingsUploader.licenseFileUploader();
            Assert.assertNotNull(LicenseUtil.getLicense());
        } catch (GelecexSignerException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
        }
    }

}