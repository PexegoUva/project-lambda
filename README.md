[![Build Status](https://travis-ci.com/PexegoUva/project-lambda.svg?branch=master)](https://travis-ci.com/PexegoUva/project-lambda)
[![Maintainability](https://api.codeclimate.com/v1/badges/23d757d574b554eeb7e7/maintainability)](https://codeclimate.com/github/PexegoUva/project-lambda/maintainability)
[![codecov](https://codecov.io/gh/PexegoUva/project-lambda/branch/master/graph/badge.svg)](https://codecov.io/gh/PexegoUva/project-lambda)

# project-lambda
Android application built with Kotlin for an American Client

### Project Architecture
This project is going to be built under [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) as I want to have a clear architecture with clear boundaries (we can achieve this applying clean).

For more information on how this Architecture has been applied to the current project with the support of other useful patterns check the wiki here -> [documentation](https://github.com/PexegoUva/project-lambda/wiki)

### Project tools
To support a clean project without bugs and a good code structure, I have added a series of tools to help me with that task.

#### Lint
 - [Detekt](https://github.com/PexegoUva/project-lambda/wiki/detekt-lint) as a static analyzer that provider a wrapper around `ktlint` 
 - [Jacoco](https://github.com/PexegoUva/project-lambda/wiki/Jacoco-Test-Coverage) as a code coverage reports generator (I want to know if my code is tested or not).
 - The generic lint for the kotlin code by using `./gradlew lintDebug`
 
#### Compilation
 - I have added [CanaryLeak](https://square.github.io/leakcanary/getting_started/) to avoid leaks on runtime, so we will be able to know that by taking a look on logs (provided by this library).

#### CI/CD
 - For this I have decided to use [TravisCI](https://github.com/PexegoUva/project-lambda/wiki/travis-ci), as it is free for public repositories and I think that is provides everything needed to cover this part for this Android project.
 
### Releases
To be able to try the app and check code, you can find `apk` and project files in the [Release](https://github.com/PexegoUva/project-lambda/releases) section of github.

There, you will find each Release generated in the project. At the moment the final Release version should be `v1.1.1-release` 
