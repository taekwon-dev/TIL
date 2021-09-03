# Setting Up Server Blocks

> When using the Nginx web server, *<u>server blocks</u>* (similar to virtual hosts in Apache) can be used to <u>encapsulate configuration details</u> and <u>host more than one domain from a single server</u>.



### | Server Configuration

- ###### /sites-available : 

  > The directory where per-site server blocks can be stored. Nginx will not use the configuration files found in this directory unless they are linked to the `sites-enabled` directory. Typically, all server block configuration is done in this directory, and then enabled <u>by linking to the other directory</u>.
  >
  > \# 실제로 변경 처리를 담당하는 곳  

- ###### /sites-enabled : 

  > The directory where enabled per-site server blocks are stored. Typically, these <u>are created by linking</u> to configuration files found in the `sites-available` directory.
  >
  > \# 변경된 내역을 링크를 통해서 생성하고, `nginx.conf` 에서 참조 

- ###### /nginx.conf :

  > The main Nginx configuration file. This can be modified to make changes to the <u>Nginx global configuration</u>.



### | Reference

###### https://www.digitalocean.com/community/tutorials/how-to-install-nginx-on-ubuntu-20-04