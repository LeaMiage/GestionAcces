for %%cmds in ("`cat %1.txt`") do (
  start "`%cmds%`"
)
