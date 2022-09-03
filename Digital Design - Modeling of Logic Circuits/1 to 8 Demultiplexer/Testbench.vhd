library IEEE;
use IEEE.std_logic_1164.all;

entity test_demux8x1 is
end test_demux8x1;

architecture testbench of test_demux8x1 is
component demux8x1
port (s0,s1,s2,D: in bit;  
      F0,F1,F2,F3,F4,F5,F6,F7: out bit);
end component;

signal tb_D: bit; signal tb_s0: bit;
signal tb_s1: bit; signal tb_s2: bit;
signal tb_F0: bit; signal tb_F1: bit;
signal tb_F2: bit; signal tb_F3: bit;
signal tb_F4: bit; signal tb_F5: bit;
signal tb_F6: bit; signal tb_F7: bit;

begin
  u0: demux8x1 port map(
  D => tb_D, s0=>tb_s0, s1=>tb_s1, s2=>tb_s2,
  F0=>tb_F0, F1=>tb_F1, F2=>tb_F2, F3=>tb_F3,
  F4=>tb_F4, F5=>tb_F5, F6=>tb_F6, F7=>tb_F7);
 
process
  begin
    -----000-----
    --  D = 0  -> F0 = 0
    tb_D <= '0';
    tb_s0 <= '0' ;
    tb_s1 <= '0' ;
    tb_s2 <= '0' ;
    wait for 10 ns;
    --  D = 1 -> F0 = 1
    tb_D <= '1';
    tb_s0 <= '0' ;
    tb_s1 <= '0' ;
    tb_s2 <= '0' ;
    wait for 10 ns;

    -----001-----
    -- D = 0 -> F1 = 0
    tb_D <= '0';
    tb_s0 <= '1' ;
    tb_s1 <= '0' ;
    tb_s2 <= '0' ;
    wait for 10 ns;
    -- με D = 1 -> F1 = 1
    tb_D <= '1';
    tb_s0 <= '1' ;
    tb_s1 <= '0' ;
    tb_s2 <= '0' ;
    wait for 10 ns;

    -----010-----
    --  D = 0 -> F2 = 0
    tb_D <= '0';
    tb_s0 <= '0' ;
    tb_s1 <= '1' ;
    tb_s2 <= '0' ;
    wait for 10 ns;
    --  D = 1 -> F2 = 1
    tb_D <= '1';
    tb_s0 <= '0' ;
    tb_s1 <= '1' ;
    tb_s2 <= '0' ;
    wait for 10 ns;

    -----011-----
    --  D = 0 -> F3 =0
    tb_D <= '0';
    tb_s0 <= '1' ;
    tb_s1 <= '1' ;
    tb_s2 <= '0' ;
    wait for 10 ns;
    --  D = 1 -> F3 = 1
    tb_D <= '1';
    tb_s0 <= '1' ;
    tb_s1 <= '1' ;
    tb_s2 <= '0' ;
    wait for 10 ns;

    -----100-----
    --  D = 0 -> F4 = 0
    tb_D <= '0';
    tb_s0 <= '0' ;
    tb_s1 <= '0' ;
    tb_s2 <= '1' ;
    wait for 10 ns;
    --  D = 1 -> F4 = 1
    tb_D <= '1';
    tb_s0 <= '0' ;
    tb_s1 <= '0' ;
    tb_s2 <= '1' ;
    wait for 10 ns;

    -----101-----
    --  D = 0 -> F5 = 0
    tb_D <= '0';
    tb_s0 <= '1' ;
    tb_s1 <= '0' ;
    tb_s2 <= '1' ;
    wait for 10 ns;
    --  D = 1 -> F5 = 1
    tb_D <= '1';
    tb_s0 <= '1' ;
    tb_s1 <= '0' ;
    tb_s2 <= '1' ;
    wait for 10 ns;

    -----110-----
    --  D = 0 -> F6 = 0
    tb_D <= '0';
    tb_s0 <= '0' ;
    tb_s1 <= '1' ;
    tb_s2 <= '1' ;
    wait for 10 ns;

    --  D = 1 -> F6 = 1
    tb_D <= '1';
    tb_s0 <= '0' ;
    tb_s1 <= '1' ;
    tb_s2 <= '1' ;
    wait for 10 ns;

    -----111-----
    --  D = 0 -> F7 = 0
    tb_D <= '0';
    tb_s0 <= '1' ;
    tb_s1 <= '1' ;
    tb_s2 <= '1' ;
    wait for 10 ns;
    --  D = 1 -> F7 = 1
    tb_D <= '1';
    tb_s0 <= '1' ;
    tb_s1 <= '1' ;
    tb_s2 <= '1' ;
    wait for 10 ns;
  end process;
end testbench;

