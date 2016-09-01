package com.myproject.sample.git;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by susannestreety on 8/31/16.
 */
public class ImplementGitHook {
    public static Logger log = LoggerFactory.getLogger(ImplementGitHook.class);

    ImplementGitHook hookClass = this;

    public static void main(String[] args) throws IOException {




        if(args.length>0){
            String sourceFilePath = args[0];
            String targetGitFilePath = args[1];

            log.debug("Source File to copy: '{}'" , sourceFilePath); // on a mac, prints /Users/<username>/IdeaProjects/sample-webapp/target/test-classes/com/myproject/sample/git/pre-push
            log.debug("Target File: '{}'" , targetGitFilePath);

            Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
            //add owners permission
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            //add group permissions
            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.GROUP_EXECUTE);
            //add others permissions
            perms.add(PosixFilePermission.OTHERS_READ);
            perms.add(PosixFilePermission.OTHERS_EXECUTE);

         //   File file3 = new File("target/test-classes/com/myproject/sample/git/pre-push");
            File sourceFile = new File(sourceFilePath);
            Path sourcePath = sourceFile.toPath();
            //File file4 = new File(".git/hooks/pre-push");
            File targetFile = new File(targetGitFilePath);
            Path targetPath = targetFile.toPath();

            Files.copy(sourcefPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            Files.setPosixFilePermissions(targetPath, perms);


        }



        
    }


}
