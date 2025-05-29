- old old version of code not updated for `GitHub`
- current one [repo](https://akashdip2001.github.io/project2/)

</br>

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

## Table of Contents
1. 🟢 [JAVA part](#java-part)
2. 🟢 [Web part](#web-part)

---

# JAVA part <a name="java-part"></a>

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
  
# 📚 Question answer (JAVA) 📚
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

---

</br>
</br>

<div style="display: flex; align-items: center; gap: 10px;" align="center">
  
# 📚 Question answer (php & sql) 📚
</div>

</br>
</br>

---

<div style="display: flex; align-items: center; gap: 10px;" align="center">
  
| `php` & `SQL` [Repo](https://github.com/akashdip2001/1st-database-InfinityFree) |
| --- |

</div>

---

# Web part <a name="web-part"></a>

## 🔧 Backend Architecture Overview

Your project comprises a web-based CAD design tool and an Android application wrapper. The backend is developed using PHP, MySQL, and JavaScript, hosted on InfinityFree. The Android app communicates with the backend via HTTP requests to PHP scripts, as direct MySQL connections are not permitted on InfinityFree's free hosting plans .

---

## 🔐 User Authentication System

### 1. **Login & Registration**

* **Frontend**: HTML/CSS forms with JavaScript for client-side validation.
* **Backend**: PHP scripts handle form submissions, validate inputs, and interact with the MySQL database to authenticate users.

### 2. **Session Management**

* PHP sessions (`$_SESSION`) are utilized to maintain user login states across different pages.

### 3. **Password Handling**

* Passwords are securely hashed using PHP's `password_hash()` function before storage in the database.

---

## 📧 Email Functionality with SMTP

### 1. **SMTP Configuration**

* To send emails (e.g., for password resets or confirmations), PHP's `mail()` function is configured to use Gmail's SMTP server.
* Due to Gmail's security policies, an App Password is generated and used for authentication instead of the primary account password .

### 2. **Email Sending Process**

* PHP scripts send emails using the configured SMTP settings, ensuring secure and reliable email delivery.

---

## 📱 Android Application Integration

### 1. **WebView Implementation**

* The Android app employs a `WebView` component to load and display the web-based CAD tool, providing a seamless user experience.

### 2. **API Communication**

* The app communicates with the backend via HTTP requests to PHP scripts, which in turn interact with the MySQL database.
* Data exchange between the app and server is facilitated using JSON format.

---

## 🗄️ Database Structure

* **Users Table**: Stores user information such as username, email, and hashed passwords.
* **Sessions Table**: Manages active user sessions and related metadata.
* **Designs Table**: Contains data related to user-created CAD designs.

---

## 🔐 Security Measures

* **Input Validation**: Both client-side (JavaScript) and server-side (PHP) validations are implemented to prevent malicious inputs.
* **Prepared Statements**: PHP's PDO or MySQLi prepared statements are used to safeguard against SQL injection attacks.
* **HTTPS**: SSL/TLS encryption is enforced to secure data transmission between the client and server.

---

## 📂 Repository Overview

* **Backend Code**: [1st-database-InfinityFree](https://github.com/akashdip2001/1st-database-InfinityFree)
* **Complete Project Structure**: [Project-2](https://github.com/Engineering-college-btech-Project2/Project-2)

---
---

## 🔐 User Authentication System

### 1. **Frontend: JavaScript Form Validation**

Before data is sent to the server, JavaScript validates user inputs to enhance user experience and reduce server load.

**Example:**

```html
<form name="loginForm" onsubmit="return validateForm()" method="post">
  <input type="text" name="username" required>
  <input type="password" name="password" required>
  <input type="submit" value="Login">
</form>

<script>
function validateForm() {
  let username = document.forms["loginForm"]["username"].value;
  let password = document.forms["loginForm"]["password"].value;
  if (username == "" || password == "") {
    alert("Both fields must be filled out");
    return false;
  }
  return true;
}
</script>
```

This script ensures that both username and password fields are filled before submission.

#### Let’s break down this:
#### **JavaScript: Client-Side Form Validation**

```html
<form name="loginForm" onsubmit="return validateForm()" method="post">
```

* `onsubmit="return validateForm()"`
  → This calls a JavaScript function before the form is sent to the server.
  → If the function returns `false`, the form will **not submit**.

```js
function validateForm() {
  let username = document.forms["loginForm"]["username"].value;
  let password = document.forms["loginForm"]["password"].value;
```

* Gets the values entered in the form.

---

```js
  if (username == "" || password == "") {
    alert("Both fields must be filled out");
    return false;
  }
  return true;
}
```

* If any field is empty, the form won’t submit, and an alert appears.
* Otherwise, it allows the form to go to PHP.

---

## 4. **Email Sending (SMTP with Gmail)**

Using PHPMailer (a library for sending email with Gmail):

```php
$mail->isSMTP();
$mail->Host = 'smtp.gmail.com';
$mail->SMTPAuth = true;
$mail->Username = 'your_email@gmail.com';
$mail->Password = 'your_app_password';
```

* `isSMTP()`
  → Tells PHPMailer to use SMTP protocol (secure email sending).
* `smtp.gmail.com`
  → Gmail’s server.
* App password is safer than your main password (from Gmail security settings).

### 2. **Backend: PHP Login Handling**

Upon form submission, PHP processes the data, interacts with the MySQL database, and manages user sessions.([W3Schools][1])

**Example:**

```php
<?php
session_start();
include 'db_connection.php'; // Contains database connection code

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $username = $_POST['username'];
  $password = $_POST['password'];

  // Prepare and execute SQL statement
  $stmt = $conn->prepare("SELECT id, password FROM users WHERE username = ?");
  $stmt->bind_param("s", $username);
  $stmt->execute();
  $stmt->store_result();

  if ($stmt->num_rows > 0) {
    $stmt->bind_result($id, $hashed_password);
    $stmt->fetch();
    if (password_verify($password, $hashed_password)) {
      $_SESSION['user_id'] = $id;
      header("Location: dashboard.php");
    } else {
      echo "Invalid password.";
    }
  } else {
    echo "No user found.";
  }
  $stmt->close();
  $conn->close();
}
?>
```

This code securely verifies user credentials and initiates a session upon successful login.

#### Let’s break down this PHP command:

## 2. **PHP: Login System Backend**

```php
session_start(); // Starts the session for this user
include 'db_connection.php'; // Connects to the database

if ($_SERVER["REQUEST_METHOD"] == "POST") {
```

* `session_start();`
  → Begins a new or resumes the current session. Used to keep a user logged in.

* `include 'db_connection.php';`
  → This includes a separate file with your database connection info (like hostname, username, password).

* `$_SERVER["REQUEST_METHOD"] == "POST"`
  → Checks if the login form was submitted using the POST method.

---

```php
  $username = $_POST['username'];
  $password = $_POST['password'];
```

* These lines get the form input from the login page.
  → `$_POST['username']` retrieves the value of the field named `username`.

---

```php
$stmt = $conn->prepare("SELECT id, password FROM users WHERE username = ?");
$stmt->bind_param("s", $username);
```

* `prepare(...)`
  → This prepares a SQL query that is safe from SQL injection.
  → `?` is a placeholder.

* `bind_param("s", $username);`
  → Binds the variable `$username` into the `?` spot. `"s"` means string.

---

```php
$stmt->execute();
$stmt->store_result();
```

* Executes the prepared statement and stores the result for checking.

---

```php
if ($stmt->num_rows > 0) {
  $stmt->bind_result($id, $hashed_password);
  $stmt->fetch();
```

* Checks if a user with that username exists.
* Binds the result to PHP variables (`$id`, `$hashed_password`) so we can use them.

---

```php
  if (password_verify($password, $hashed_password)) {
    $_SESSION['user_id'] = $id;
    header("Location: dashboard.php");
```

* `password_verify(...)`
  → Compares the typed password with the hashed password from the database.
* If matched, we store the user ID in a session and redirect them to a new page.

---

## 📧 Email Functionality with SMTP

To handle tasks like password resets, your application sends emails using Gmail's SMTP server.([CodeShack][2])

**Example using PHPMailer:**

```php
<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'vendor/autoload.php';

$mail = new PHPMailer(true);
try {
  //Server settings
  $mail->isSMTP();
  $mail->Host = 'smtp.gmail.com';
  $mail->SMTPAuth = true;
  $mail->Username = 'your_email@gmail.com';
  $mail->Password = 'your_app_password';
  $mail->SMTPSecure = 'tls';
  $mail->Port = 587;

  //Recipients
  $mail->setFrom('your_email@gmail.com', 'Your Name');
  $mail->addAddress('recipient@example.com', 'Recipient Name');

  //Content
  $mail->isHTML(true);
  $mail->Subject = 'Password Reset';
  $mail->Body    = 'Click <a href="reset_link">here</a> to reset your password.';

  $mail->send();
  echo 'Message has been sent';
} catch (Exception $e) {
  echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}
?>
```



This script configures PHPMailer to send emails via Gmail's SMTP server.([CodeShack][2])

---

## 🗄️ Database Structure <a name="app-sql-explane"></a>

my MySQL database includes a `users` table to store user information.

**Example:**

```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

This schema ensures unique usernames and emails, storing hashed passwords securely.

#### Let’s break down this SQL command:
### Explanation:

* `CREATE TABLE users (...)`
  → This command creates a new table named `users`.

* `id INT AUTO_INCREMENT PRIMARY KEY`
  → `id` is the **Primary Key**: it uniquely identifies each row.
  → `INT` means it stores whole numbers.
  → `AUTO_INCREMENT` means the value increases automatically (1, 2, 3, ...).

* `username VARCHAR(50) NOT NULL UNIQUE`
  → Stores usernames up to 50 characters.
  → `NOT NULL` means this field cannot be left empty.
  → `UNIQUE` means no two users can have the same username.

* `email VARCHAR(100) NOT NULL UNIQUE`
  → Same as `username` but allows longer email values (up to 100 characters).

* `password VARCHAR(255) NOT NULL`
  → Stores hashed passwords. Passwords are hashed, so we use 255 characters to safely hold the encrypted version.

* `created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP`
  → Records the date and time when the account was created, automatically.

---

## 📱 Android Application Integration

Your Android app uses a WebView to display the web-based CAD tool.

**Example:**

```java
WebView webView = findViewById(R.id.webview);
webView.getSettings().setJavaScriptEnabled(true);
webView.loadUrl("https://yourdomain.com/cad-tool");
```



This code initializes the WebView and loads the CAD tool URL.

---

## 🔐 Security Measures

* **Input Validation:** Both client-side (JavaScript) and server-side (PHP) validations are implemented to prevent malicious inputs.

* **Prepared Statements:** PHP's prepared statements are used to safeguard against SQL injection attacks.

* **Password Hashing:** Passwords are hashed using `password_hash()` before storage.

* **HTTPS:** SSL/TLS encryption is enforced to secure data transmission between the client and server.

---

[1]: https://www.w3schools.com/js/js_validation.asp?utm_source=chatgpt.com "JavaScript Form Validation - W3Schools"
[2]: https://codeshack.io/send-emails-php-gmail-smtp/?utm_source=chatgpt.com "How to Send Emails in PHP with Gmail SMTP - CodeShack"


