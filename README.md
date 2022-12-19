# Password Hasher CLI Tool

A simple command-line tool for generating password hashes using various algorithms.

## Usage

To generate a password hash, run the following command:

```bash
java -jar password-hasher-cli-tool-1.0-fat.jar --password <password> --algorithm <algorithm>
```

Where:

- `<password>` is the password to be hashed
- `<algorithm>` is the hash algorithm to use (e.g. `SHA-256`, `MD5`)

## Examples

To generate an MD5 hash of the password `Kek123`, run:

```bash
java -jar password-hasher-cli-tool-1.0-fat.jar --password Kek123 --algorithm MD5
```

This will output the hash value: `c5528cb986f6d0c6ebdef5c45b835ea7`

To generate an SHA-256 hash of the password `Lol456`, run:

```bash
java -jar password-hasher-cli-tool-1.0-fat.jar --password Lol456 --algorithm SHA-256
```

This will output the hash value: `e4989b9b54fa72385677d05a494f80258e62d5d8e4b8de7a67e3d64033d9bcc7`

## Options
The `password-hasher-cli-tool` supports the following command-line options:

* `--password <password>`: Required. The password to be hashed.
* `--algorithm <algorithm>`: Required. The hash algorithm to use. Supported algorithms include:
  * MD5: Generates an MD5 hash of the password.
  * MD2: Generates an MD2 hash of the password.
  * SHA-1: Generates an SHA-1 hash of the password.
  * SHA-224: Generates an SHA-224 hash of the password.
  * SHA-256: Generates an SHA-256 hash of the password.
  * SHA-384: Generates an SHA-384 hash of the password.
  * SHA-512: Generates an SHA-512 hash of the password.
