# Pizza Palace
This app is meant to support a pizza restaraunt. Through the app you can view current discounts/sales, learn more about the company, and order a pizza for take out or delivery. This app was created for a group project in Android Development 2 at St. Clair College.

## Main Page
![image](https://user-images.githubusercontent.com/32267704/34951390-1e77b218-f9e4-11e7-88b1-dbf855e6212e.png)

## Current Specials Page
![image](https://user-images.githubusercontent.com/32267704/34951512-90f1ec6e-f9e4-11e7-8c1c-6a1415aa4502.png)

## Order Page
![image](https://user-images.githubusercontent.com/32267704/34951615-dd9a1f14-f9e4-11e7-857f-9277206ad9bc.png)

## Tip Calculator
![image](https://user-images.githubusercontent.com/32267704/34951566-baa9baf0-f9e4-11e7-81e1-89937200a41a.png)

## Git Config Instructions
`git config --global user.name` `<<<YOUR NAME HERE>>>`

`git config --global user.email` `<<<YOUR EMAIL HERE>>>`

## Commiting Instructions

Download/Clone the project from the repository

Perform the Git Config Instructions

Perform a `git branch -a` to see all the branches on the github repo

'git checkout staging' so that it creates a local copy of staging you can branch from

Create a branch that branches from staging and check it out `git checkout -b branchname`

When you are ready to put your work into staging (the main project) you do the following
Checkout staging `git checkout staging`

Pull staging (ensure your local staging is up to date with the copy on origin) 'git pull'

Checkout your branch `git checkout branchname`

Merge staging into your branch (This may cause a merge conflict if staging had content it downloaded) 'git merge staging'

Fix any issues that are in your project indicated by <<<<<<head ======== >>>>>>branchname

Once all issues are fixed perform another commit `git add .` and `git commit -m “”`
Checkout staging `git checkout staging`

Perform a git pull (to ensure staging did not change while we were making fixes) `git pull`

##  IMPORTANT (if there are no changes then we can proceed. If there are changes and updates are downloaded we repeat the above steps)

If no conflicts appeared and everything is up to date you are ready for your code to make its way into staging

Push your branch to github  `git push origin branchname`

Go to GitHub and perform a pull request (possibly tag a group member to get it done faster)

## Additional Tips
Document everything you do with JavaDoc Comments

With each commit comment the issue it is addressing `git commit -m "#4 this addresses isssue number 4"`
