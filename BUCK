
# === Dependencies ===

APP_JAR_DEPS = []
TEST_JAR_DEPS = []

for f in glob(['libs/app/*.jar']):
  name = 'jar__' + re.sub(r'^.*/([^/]+)\.jar$', r'\1', f)
  APP_JAR_DEPS.append(':' + name)
  prebuilt_jar(name = name, binary_jar = f)

for f in glob(['libs/test/*.jar']):
  name = 'jar__' + re.sub(r'^.*/([^/]+)\.jar$', r'\1', f)
  TEST_JAR_DEPS.append(':' + name)
  prebuilt_jar(name = name, binary_jar = f)

# === App Manifests ===

android_manifest(
  name = 'debug-manifest',
  skeleton = 'AndroidManifest.xml',
  deps = [
    ':main-lib',
  ],
)

genrule(
  name = 'release-manifest',
  srcs = [
    'AndroidManifest.xml'
  ],
  bash = "cat AndroidManifest.xml | sed -e \'s/debuggable=\"true\"/debuggable=\"false\"/g\' > $OUT",
  out = 'AndroidManifest_release.xml',
)

# === App Source ===

android_build_config(
  name = 'build-config',
  package = APP_PACKAGE,
)

android_library(
  name = 'all-jars',
  exported_deps = APP_JAR_DEPS,
)

android_library(
  name = 'main-lib',
  srcs = glob([APP_SRC_PATH + '/**/*.java']),
  deps = [
    ':build-config',
    ':all-jars',
    '//' + APP_RES_PATH + ':res',
  ]
)

# === App binaries ===

for build_type in BUILD_TYPES:
  android_binary(
    name = 'callme_' + build_type,
    manifest = ':' + build_type + '-manifest',
    keystore = '//keystore:' + build_type,
    package_type = build_type,
    deps = [
      ':main-lib'
    ]
  )

# === Unit test ===

java_library(
  name = 'all-test-jars',
  exported_deps = TEST_JAR_DEPS
)

java_test(
  name = 'unit-tests',
  srcs = glob([UNIT_TEST_PATH + '/**/*.java']),
  deps = [
    ':main-lib',
    ':all-test-jars'
  ]
)