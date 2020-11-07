# COUPIN-DATABASE on MariaDB

## Environment

- Docker CE
- MariaDB 10.5 (docker container)

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

- Set `random` root user password for MariaDB container in yout `shrc`.

  ```bash
  # SETTING
  echo "" >> ~/.zshrc
  echo "# =======[ RANDOM-COUPIN-DATABASE ]=======" >> ~/.zshrc
  echo "RANDOM_COUPIN_DB_PASSWORD=`whoami`_$RANDOM" >> ~/.zshrc
  echo "# ========================================" >> ~/.zshrc
  echo "" >> ~/.zshrc
  ```

- Check

  ```bash
  # RELOAD 
  source ~/.zshrc
  echo "Random ROOT password (for COUPIN-DATABASE): $RANDOM_COUPIN_DB_PASSWORD"
  ```

## Run `single mariadb container` for devevlop environment

- Run `MariaDB:10.5 container`

  ```bash
  docker run -d -p 3306:3306 \
   -e MYSQL_ROOT_PASSWORD=$RANDOM_COUPIN_DB_PASSWORD \
   --name coupin-database-mariadb \
   mariadb:10.5
  ```

- Check container log that has ready for connections.

  ```bash
  docker logs --tail 2 coupin-database-mariadb
   # [Note] mysqld: ready for connections.
   # Version: '10.5.7-MariaDB-1:10.5.7+maria~focal'  socket: '/run/mysqld/mysqld.sock'  port: 3306  mariadb.org binary distribution

  docker container ls | grep coupin
   #  mariadb:10.5    "docker-entrypoint.s…"  (create-time) (up-time)  0.0.0.0:3306->3306/tcp   coupin-database-mariadb
  ```

- Connect to MariaDB Client (like [DBeaver CE](https://dbeaver.io/download/)).

  ```bash
  # COPY IN CLIPBOARD & PASTE TO INPUT BOX
  echo "Random ROOT password (for COUPIN-DATABASE): $RANDOM_COUPIN_DB_PASSWORD"
  ```

  ![example](https://user-images.githubusercontent.com/48089867/98438466-cbb7d700-212d-11eb-991a-ff8ed7fd60bc.png)

- Done!

