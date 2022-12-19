package dev.yawkar.hashertool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        Options options = new Options();
        Option passwordOption = Option.builder("p")
                .longOpt("password")
                .hasArg()
                .argName("PASSWORD")
                .desc("The password to be hashed")
                .required()
                .build();
        options.addOption(passwordOption);
        Option algorithmOption = Option.builder("a")
                .longOpt("algorithm")
                .hasArg()
                .argName("ALGORITHM")
                .desc("The hash algorithm to use (e.g. SHA-256, MD5)")
                .required()
                .build();
        options.addOption(algorithmOption);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            String password = cmd.getOptionValue("password");
            String algorithm = cmd.getOptionValue("algorithm");

            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(password.getBytes());

            System.out.println(bytesToHex(hash));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("password-hasher-cli-tool", options);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: specified hash algorithm not found");
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
