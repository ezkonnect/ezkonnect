#! /bin/bash
if [ -f ~/.bashrc ]; then
        . ~/.bashrc
fi
Mail=faheemrao@gmail.com
case "$(pidof java | wc -w)" in

0)  echo "Restarting vconnect-services:     $(date)" >> /home/ec2-user/vconnect.txt
    echo "vConnect Services were restarted by automated job" | mailx -S "vConnect Service notification" $Mail
    cd /home/ec2-user/vconnect/vconnect-services
    mvn spring-boot:run &
    ;;
1)  # all ok
    ;;
*)  echo "Removed double vconnect-Services: $(date)" >> /home/ec2-user/vconnect.txt
    echo "vConnect Services were running more than one , killed  last one running by automated job" | mailx -S "vConnect Service notification" $Mail
    kill $(pidof java | awk '{print $1}')
    ;;
esac
