package de.dfki.mary.voicebuilding

import org.testng.annotations.*

class VoiceExtensionTest {

    def voice

    @BeforeTest
    void setup() {
        voice = new VoiceExtension()
    }

    @Test
    void testName() {
        assert voice.name == 'my_voice'
        assert voice.nameCamelCase == 'My_voice'
        voice.name = 'foo-bar-baz'
        assert voice.nameCamelCase == 'FooBarBaz'
    }

    @Test
    void testLocale() {
        assert voice.locale == Locale.US
        assert voice.localeXml == 'en-US'
        assert voice.maryLocale == 'en_US'
        assert voice.maryLocaleXml == 'en-US'
        voice.region = 'GB'
        assert voice.locale == Locale.UK
        assert voice.localeXml == 'en-GB'
        assert voice.maryLocale == 'en_GB'
        assert voice.maryLocaleXml == 'en-GB'
        voice.language = 'de'
        voice.region = 'DE'
        assert voice.locale == Locale.GERMANY
        assert voice.localeXml == 'de-DE'
        assert voice.maryLocale == 'de'
        assert voice.maryLocaleXml == 'de'
    }
}
