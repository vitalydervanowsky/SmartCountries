package by.dzrvnsk.smartcountries

import androidx.navigation.navOptions

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
