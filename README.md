Call Me
========

Android marshmallow text handler to directly call or SMS phone numbers.

The app also serves as an experiment in using the buck build system

Building
--------

Compile APK:

```
buck build [debug|release]
```

Install APK:

```
buck install [release|debug]
```

Run tests:

```
buck test
```

Note that to build a release APK, you will need to supply `release.keystore` and `release.keystore.properties` files in the `keystore` folder