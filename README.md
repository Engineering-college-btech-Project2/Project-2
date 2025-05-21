![Screenshot (39)](https://github.com/Engineering-college-btech-Project2/Project-2/assets/81384987/65c73ef4-f1fd-4c5e-9b34-ddd6e6e95291)
![Screenshot (40)](https://github.com/Engineering-college-btech-Project2/Project-2/assets/81384987/4052fd03-78e8-4301-800d-ff47f8163cb1)

| Downlod | PlayStore | Amazon AppStore |
| --- | --- | --- |
|  | [Downlod](https://play.google.com/store/apps/details?id=com.akashdipmahapatra.freecad&hl=en-US&ah=ABYAKvajUYaCOzFn9PtBjgUA21s) | [Downlod](https://www.amazon.com/gp/product/B0CYV2BSGH) |


Last update - 17/03/2024

- versionCode = 5
- versionName = "1.0.2.5"

---

</br>
</br>

<div style="display: flex; align-items: center; gap: 10px;" align="center">
  
# ⭐ interview preparation ⭐
</div>

</br>
</br>

---

[php & SQL](https://github.com/akashdip2001/1st-database-InfinityFree)

---

## **1-Minute App Presentation (Speech Format)**

> “I created a mobile app using **Java and Android Studio** that acts as a wrapper for a web-based CAD design tool I built. Since the core app is in HTML/JavaScript, I used **WebView** in Java to embed the webpage directly in my Android app, enabling mobile users to access it easily.

> I used **Java fundamentals** like classes, methods, event handling, and object-oriented principles such as **inheritance** and **encapsulation** to structure the app code. For example, the main logic runs inside the `MainActivity` class, and I used **anonymous inner classes** for button click listeners.

> I also implemented key Android features like:

* **Checking internet connection** using `ConnectivityManager`
* **Blocking screenshots** with `FLAG_SECURE`
* **Locking screen orientation** programmatically
* **Refreshing WebView**
* And showing a custom **offline error page** using local assets.

> This project helped me apply Java in a real-world context, combining both front-end and native mobile development. The app is already published on the Play Store and tested across multiple devices.”

---

## **Java Fundamentals You Can Mention (if asked)**

Here are short definitions you can memorize and say naturally:

1. **Class and Object**:

   > "A class is a blueprint; an object is an instance of that blueprint."

2. **Inheritance**:

   > "Used when a class wants to acquire properties of another class. I extended `AppCompatActivity` in my MainActivity."

3. **Encapsulation**:

   > "I kept WebView and button variables private and accessed them through methods within the class."

4. **Polymorphism**:

   > "I used method overriding—like overriding `onCreate()` and event listeners."

5. **Abstraction**:

   > "Android uses abstract classes and interfaces behind the scenes, like `WebViewClient` and `View.OnClickListener`."

6. **Interface**:

   > "I used interfaces like `View.OnClickListener` for button clicks."

7. **Exception Handling**:

   > "I used try-catch blocks where needed, especially in networking code."

---

</br>
</br>

<div style="display: flex; align-items: center; gap: 10px;" align="center">
  
# 📚 Question answer 📚
</div>

</br>
</br>

---

## **How to Start Explaining Your Project in Interview (Verbal + Technical Flow)**

---

### **1. Introduction to the App**

> “I developed a mobile app using Java and Android Studio which displays a full-featured CAD interface inside a WebView. The CAD application itself is web-based, but I built a native Android shell around it so that users can install and use it like a real mobile app. It's already published on the Play Store.”

---

### **2. Why I Used WebView**

> “Since the main features are in HTML, CSS, and JavaScript, I used Android's WebView to load the webpage inside the app. WebView helps me integrate web content directly in Android.”

---

### **3. Key Features I Implemented (With Verbal Code Explanation)**

---

#### **a. Load WebView + Enable JavaScript**

> “I created a `WebView` in my layout file, and in Java code, I enabled JavaScript using `.getSettings().setJavaScriptEnabled(true)`. This is necessary for modern web pages to function properly.”

**Code:**

```java
webView.getSettings().setJavaScriptEnabled(true);
webView.setWebViewClient(new WebViewClient());
webView.loadUrl("https://your-web-app-url.com");
```

---

#### **b. Check Internet Connection**

> “Before loading the page, I check if the device is connected to the internet using `ConnectivityManager`. If there's no internet, I show a Toast or redirect to an offline page.”

**Code:**

```java
ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo netInfo = cm.getActiveNetworkInfo();

if (netInfo != null && netInfo.isConnected()) {
    webView.loadUrl("https://your-web-app-url.com");
} else {
    webView.loadUrl("file:///android_asset/no_internet.html");
}
```

---

#### **c. Handle Screen Orientation**

> “By default, I locked the orientation to portrait mode using `setRequestedOrientation`. But if the user opens a video in full-screen, I temporarily allow landscape to support that.”

**Code to lock:**

```java
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
```

**Code to allow landscape in video (optional logic):**
You would override WebChromeClient’s `onShowCustomView()` to detect fullscreen video and switch orientation.

---

#### **d. Disable Screenshots / Screen Recording**

> “For content protection, I used a flag in my activity that prevents taking screenshots or screen recording.”

**Code:**

```java
getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
```

---

#### **e. Refresh Button**

> “I added a refresh button so that users can manually reload the WebView if needed. It just calls `webView.reload()` when clicked.”

**Code:**

```java
refreshButton.setOnClickListener(v -> webView.reload());
```

---

#### **f. Display Offline Error Page**

> “If there’s no internet, I don’t just show a Toast, I load a local HTML file from the assets folder that displays a proper error message with UI.”

**Code:**

```java
webView.loadUrl("file:///android_asset/no_internet.html");
```

---

#### **g. Use String Resources**

> “To keep URLs and app name clean, I used `strings.xml` so I can manage content easily and support localization later.”

**strings.xml**

```xml
<string name="webview_url">https://your-web-app-url.com</string>
```

**Usage in Java:**

```java
webView.loadUrl(getString(R.string.webview_url));
```

---

### **4. Common Issues I Faced and How I Fixed Them**

* **Black Screen in WebView**: I solved this by enabling JavaScript, setting a WebViewClient, and checking internet connection.
* **Page not loading**: I ensured the `INTERNET` permission was added to `AndroidManifest.xml`.
* **App crashing in landscape**: I fixed orientation issues by locking it manually.

---

### **5. How I Published the App**

> “After development, I signed and built the APK using Android Studio, created a Play Console account, and uploaded it following all Play Store policies. It’s now live.”

---
