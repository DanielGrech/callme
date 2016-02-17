import re

BUILD_TYPES = ['debug', 'release']

APP_PACKAGE = 'com.dgsd.android.callme'
APP_SRC_PATH = 'src/java/' + APP_PACKAGE.replace('.', '/')
UNIT_TEST_PATH = 'src/test/' + APP_PACKAGE.replace('.', '/')
APP_RES_PATH = 'src/res/' + APP_PACKAGE.replace('.', '/')