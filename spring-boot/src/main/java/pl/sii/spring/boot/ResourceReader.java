package pl.sii.spring.boot;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class ResourceReader {
    private static final String IMAGES_PATTERN = "classpath*:contents/Sii*jpg";
    private final ResourceLoader resourceLoader;

    public ResourceReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public File getImagesAsZip() throws IOException {
        File zipFile = File.createTempFile("sii_images", ".zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (Resource image : getImages()) {
                addImageToZip(image.getInputStream(), image.getFilename(), zos);
            }
        }
        return zipFile;
    }

    private void addImageToZip(InputStream inputStream, String filename, ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(filename);
        zos.putNextEntry(zipEntry);
        IOUtils.copy(inputStream, zos);
        zos.closeEntry();
    }

    private List<Resource> getImages() throws IOException {
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(IMAGES_PATTERN);
        return Arrays.asList(resources);
    }
}
