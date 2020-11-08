# COUPIN-DATABASE on MySQL 8

## Environment

- Docker CE
- MySQL 8 

## Default setting

- Check your shell version.

  ```bash
  $SHELL --version
  # LIKE THESE..
    # zsh 5.8 (x86_64-apple-darwin19.3.0)
  # OR..
    # GNU bash, version 3.2.57(1)-release (x86_64-apple-darwin19)
    # Copyright (C) 2007 Free Software Foundation, Inc.
  ```

- Before run, backup your `shrc`(shell run command)

  ```bash
  # IF BASH
  cp ~/.bashrc ~/.bashrc_`date '+%Y-%m-%d'`_coupin
  ls -ahl ~ | grep ".bashrc"
  ```

  ```bash
  # IF ZSH
  cp ~/.zshrc ~/.zshrc_`date '+%Y-%m-%d'`_coupin
  ls -ahl ~ | grep ".zshrc"
  ```

- Set `random` root user password for mysql container in yout `shrc`.

  ```bash
  # SETTING
  echo "" >> ~/.zshrc
  echo "# ==========[ RANDOM-COUPIN-DATABASE ]===========" >> ~/.zshrc	
  echo "export RANDOM_COUPIN_DB_PASSWORD=`whoami`_$RANDOM" >> ~/.zshrc
  echo "# ===============================================" >> ~/.zshrc
  echo "" >> ~/.zshrc
  ```

- Check

  ```bash
  # RELOAD 
  source ~/.zshrc
  echo "Random ROOT password (for COUPIN-DATABASE): $RANDOM_COUPIN_DB_PASSWORD"
  ```

## How to use

### Run mysql container

   ```bash
   docker run -d \
    -e MYSQL_ROOT_PASSWORD=$RANDOM_COUPIN_DB_PASSWORD \
    -p 3306:3306 \
    --name coupin-mysql \
    dev2sponge/coupin-database-mysql

   docker logs -tf --tail 10 coupin-mysql

   docker container ls | grep coupin
    #  dev2sponge/coupin-database-mysql latest  "docker-entrypoint.s…"  (create-time) (up-time)  0.0.0.0:3306->3306/tcp   coupin-mysql
   ```

- Check container log that has ready for connections.

  ```bash
  docker logs -tf --tail 5 coupin-mysql
    # ...
    # [Note] mysqld: ready for connections.
    # Version: '10.5.7-mysql-1:10.5.7+maria~focal' ...

    # Exit to type `ctrl + c`

  docker container ls | grep coupin
    #  mysql:10.5    "docker-entrypoint.s…"  (create-time) (up-time)  0.0.0.0:3306->3306/tcp   coupin-mysql
  ```

- Connect to mysql Client (like [DBeaver CE](https://dbeaver.io/download/)).

  ```bash
  # COPY IN CLIPBOARD & PASTE TO INPUT BOX
  echo "Random ROOT password (for COUPIN-DATABASE): $RANDOM_COUPIN_DB_PASSWORD"
  ```

  ![example](https://user-images.githubusercontent.com/48089867/98438466-cbb7d700-212d-11eb-991a-ff8ed7fd60bc.png)

### Stop & Remove container

- Stop container

  ```bash
  docker stop coupin-mysql
  ```

- Remove container

  ```bash
  # Must be stopped first
  docker rm coupin-mysql
  ```

- Remove docker image

  ```bash
  docker rmi dev2sponge/coupin-database-mysql
  ```

---

### Docker image's history

- Build docker image with [dockerfile](./dockerfile)

  ```bash
  docker build -t dev2sponge/coupin-database-mysql . 
  ```

- Push docker image

  ```bash
  docker push dev2sponge/coupin-database-mysql
  ```