package com.github.calintat

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.preference.PreferenceManager

/**
 * The default shared preferences of the given context.
 */
val Context.defaultPreferences: SharedPreferences

    get() = PreferenceManager.getDefaultSharedPreferences(this)

/**
 * Retrieve a boolean value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (false by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException if there is a preference with this name that is not a boolean.
 */
fun Context.getBoolean(key: String, defValue: Boolean = false): Boolean {

    return defaultPreferences.getBoolean(key, defValue)
}

/**
 * Set a boolean value in the default preferences.
 *
 * Note that if this value is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putBoolean(key: String, value: Boolean?) {

    value?.let { defaultPreferences.edit().putBoolean(key, it).apply() }
}

/**
 * Retrieve a float value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException if there is a preference with this name that is not a float.
 */
fun Context.getFloat(key: String, defValue: Float = 0f): Float {

    return defaultPreferences.getFloat(key, defValue)
}

/**
 * Set a float value in the default preferences.
 *
 * Note that if this value is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putFloat(key: String, value: Float?) {

    value?.let { defaultPreferences.edit().putFloat(key, it).apply() }
}

/**
 * Retrieve an int value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException if there is a preference with this name that is not an int.
 */
fun Context.getInt(key: String, defValue: Int = 0): Int {

    return defaultPreferences.getInt(key, defValue)
}

/**
 * Set an int value in the default preferences.
 *
 * Note that if this value is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putInt(key: String, value: Int?) {

    value?.let { defaultPreferences.edit().putInt(key, it).apply() }
}

/**
 * Retrieve a long value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException if there is a preference with this name that is not a long.
 */
fun Context.getLong(key: String, defValue: Long = 0): Long {

    return defaultPreferences.getLong(key, defValue)
}

/**
 * Set a long value in the default preferences.
 *
 * Note that if this value is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putLong(key: String, value: Long?) {

    value?.let { defaultPreferences.edit().putLong(key, it).apply() }
}

/**
 * Retrieve a non-null string value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException if there is a preference with this name that is not a string.
 */
fun Context.getString(key: String, defValue: String = ""): String {

    return defaultPreferences.getString(key, defValue)
}

/**
 * Retrieve a nullable string value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 *
 * @return Returns the preference value if it exists, or null.
 *
 * @throws ClassCastException if there is a preference with this name that is not a string.
 */
fun Context.getStringOrNull(key: String): String? {

    return defaultPreferences.getString(key, null)
}

/**
 * Set a string value in the default preferences.
 *
 * Note that if this value is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putString(key: String, value: String?) {

    value?.let { defaultPreferences.edit().putString(key, it).apply() }
}

/**
 * Retrieve a set of boolean values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException if there is a preference with this name that is not a set.
 */
fun Context.getBooleanSet(key: String, defValues: Set<Boolean> = emptySet()): Set<Boolean> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toBoolean)
}

/**
 * Set a set of boolean values in the default preferences.
 *
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putBooleanSet(key: String, values: Set<Boolean>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieve a set of float values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException if there is a preference with this name that is not a set.
 */
fun Context.getFloatSet(key: String, defValues: Set<Float> = emptySet()): Set<Float> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toFloatOrNull)
}

/**
 * Set a set of float values in the default preferences.
 *
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putFloatSet(key: String, values: Set<Float>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieve a set of int values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or defValues.
 *
 * @throws ClassCastException if there is a preference with this name that is not a set.
 */
fun Context.getIntSet(key: String, defValues: Set<Int> = emptySet()): Set<Int> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toIntOrNull)
}

/**
 * Set a set of int values in the default preferences.
 *
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putIntSet(key: String, values: Set<Int>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieve a set of long values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or defValues.
 *
 * @throws ClassCastException if there is a preference with this name that is not a set.
 */
fun Context.getLongSet(key: String, defValues: Set<Long> = emptySet()): Set<Long> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toLongOrNull)
}

/**
 * Set a set of long values in the default preferences.
 *
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putLongSet(key: String, values: Set<Long>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieve a set of string values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException if there is a preference with this name that is not a set.
 */
fun Context.getStringSet(key: String, defValues: Set<String> = emptySet()): Set<String> {

    return defaultPreferences.getStringSet(key, defValues)
}

/**
 * Set a set of string values in the default preferences.
 *
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putStringSet(key: String, values: Set<String>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, it).apply() }
}

/**
 * Populate the given container with a preference fragment generated from an XML resource.
 *
 * @param containerViewId Identifier of the container where the fragment will be added.
 * @param preferencesResId The XML resource ID to inflate.
 */
fun Activity.populateWithPreferences(containerViewId: Int, preferencesResId: Int) {

    val settingsFragment = SettingsFragment()

    val args = Bundle()

    args.putInt(settingsFragment.PREFERENCE_RES_ID, preferencesResId)

    settingsFragment.arguments = args

    fragmentManager.beginTransaction().replace(containerViewId, settingsFragment).commit()
}

/**
 * Implementation of the preference fragment which inflates a given XML resource.
 *
 * Note that you must pass the XML resource ID as a construction argument.
 */
class SettingsFragment : PreferenceFragment() {

    val PREFERENCE_RES_ID = "com.calintat.github.PREFERENCE_RES_ID"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        addPreferencesFromResource(arguments.getInt(PREFERENCE_RES_ID))
    }
}

/**
 * Convert a set of strings to a set of values of type [T].
 *
 * Note that [transform] must return null if it fails, and those values will be omitted.
 */
private fun <T : Any> convert(set: Set<String>, transform: (String) -> T?): Set<T> {

    return set.map(transform).filterNotNull().toSet()
}

/**
 * Convert a set of values of type [T] to a set of strings.
 */
private fun <T> convert(set: Set<T>) = set.map { it.toString() }.toSet()