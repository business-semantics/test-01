# test-01

Test repository for dependency and CVE scanning. It reproduces the third-party dependency set of a
real multi-module Maven library repository, without any of its code.

- `test-01-bom` - copy of the real BOM with only the third-party entries (versions, scopes, classifiers,
  exclusions and version properties unchanged). Imported by `test-03`.
- `test-01-parent` - imports the BOM, like the real sub-parents do.
- `test-01-core`, `test-01-documents`, `test-01-http`, `test-01-persistence`, `test-01-search` - every
  BOM entry is declared by exactly one module (or by the root POM) and each module references a class
  of every library it declares.

Version `25.4.10-SNAPSHOT`, deployed to the same Artifactory repositories as the real repository:

```
mvn clean deploy
```
