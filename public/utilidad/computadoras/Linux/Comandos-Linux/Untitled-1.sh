#!/bin/bash

actualizar() { if sudo apt update && sudo apt upgrade -y; then sudo systemctl poweroff; else actualizar; fi }; actualizar
