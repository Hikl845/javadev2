plugins {
    id 'java'
    id 'application'
}

group = 'org.example'
version = '1.0'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.google.code.gson:gson:2.13.2'
}

application {
    mainClass = 'org.example.Main'
}

jar {
    archiveFileName = 'myname.jar'

    manifest {
        attributes 'Main-Class': 'org.example.Main'
    }

    from {
        configurations.runtimeClasspath.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
}
