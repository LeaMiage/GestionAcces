FOR /f %%cmds IN ("cat %1.txt") DO (
start "`%cmds%`"
)