package com.challlen.gradle

import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

class KarmaBaseSpec extends Specification {

    @Shared
    KarmaModuleExtension karmaConfig

    def setup() {
        karmaConfig = new KarmaModuleExtension()
    }

    protected void karma(Closure closure) {
        closure.rehydrate(karmaConfig, karmaConfig, karmaConfig).call()
    }

    protected getConfigMap() {
        new JsonSlurper().parseText(karmaConfig.configJson)
    }

    protected Profile getProfile(String name) {
        Profile profile = KarmaConstants.PROFILES[name].clone()
        profile.setDefaults()
        profile
    }
}
