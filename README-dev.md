# Git Flow Rule

## Setup

```bash
# on Mac OS X
brew install git-flow


```

## Flow

1. Clone git-repo

   ```bash
   git clone https://github.com/devJRL/Coupin.git && cd Coupin
   ```

2. Init local git-flow

   ```bash
   git flow init
     # Branch name for production releases: [master] main
     # Branch name for "next release" development: [develop] (enter)

     # How to name your supporting branch prefixes?
     # Feature branches? [feature/] (enter)
     # Release branches? [release/] (enter)
     # Hotfix branches? [hotfix/] (enter)
     # Support branches? [support/] (enter)
     # Version tag prefix? [] tag

   git status
     # On branch develop
     # ...
   ```

3. Start feature development `with naming rule`

   ```bash
   git flow feature start {type/target}
     # eg.
     # git flow feature start setting/initialize
     # git flow feature start front/page/landing
     # git flow reature start back/api/login
   ```

4. Push commits to the remote-repo (origin)

   ```bash
   # Check This branch-name
   echo `git status | grep "On branch" | cut -c 11-`

   # Push
   git push origin `git status | grep "On branch" | cut -c 11-`
   ```

5. Pull develop branch status

   ```bash
   prev_branch=`git status | grep "On branch" | cut -c 11-`
   echo $prev_branch

   git checkout develop
   git pull origin develop

   git checkout $prev_branch
   ```

6. Finish feature development

   ```bash
   git flow feature finish {type/target}
     # eg.
     # git flow feature finish setting/initialize
     # git flow feature finish front/page/landing
     # git flow reature finish back/api/login
   ```

7. Push `develop` branch to the remote-repo (origin)

   ```bash
   git push origin develop
   ```

8. Create Pull request from `develop` to `main` [in Github]

9. Check build & test, then `merge` [in Github]

10. Pull from the remote-repo (origin)

    ```bash
    git pull -u origin {branch-name}
    ```
