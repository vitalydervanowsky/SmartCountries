package by.dzrvnsk.smartcountries

import androidx.navigation.navOptions

const val LAST_LOGIN = "LAST_LOGIN"
const val LAST_SCORES = "LAST_SCORES"
const val LAST_TIME = "LAST_TIME"
const val LAST_POINTS = "LAST_POINTS"

const val NO_COUNTRY_NAME = ""
const val NO_COUNTRY_FLAG = ""
const val NO_NAME = ""
const val NO_POINTS = 0F
const val NO_SCORES = 0
const val NO_TIME = 0L

const val QUIZ_SIZE = 10

const val RANDOM_COUNTRY = "RANDOM_COUNTRY"
const val RANDOM_COUNTRY_NAME = "RANDOM_COUNTRY_NAME"
const val RANDOM_COUNTRY_FLAG = "RANDOM_COUNTRY_FLAG"

const val START_ATTEMPT = 1
const val START_POSITION = 0
const val START_SCORES = 0
const val START_TIME_DURATION = 0L

val NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM = navOptions {
    anim {
        enter = R.anim.slide_in_bottom
        exit = R.anim.fade_out
        popEnter = R.anim.fade_in
        popExit = R.anim.slide_out_bottom
    }
}

val NAV_OPTIONS_ANIMATION_SLIDE_IN_RIGHT = navOptions {
    anim {
        enter = R.anim.slide_in_right
        exit = R.anim.fade_out
        popEnter = R.anim.fade_in
        popExit = R.anim.slide_out_right
    }
}

val NAV_OPTIONS_ANIMATION_SCALE_IN = navOptions {
    anim {
        enter = R.anim.scale_in
        exit = R.anim.fade_out
        popEnter = R.anim.fade_in
        popExit = R.anim.scale_out
    }
}
