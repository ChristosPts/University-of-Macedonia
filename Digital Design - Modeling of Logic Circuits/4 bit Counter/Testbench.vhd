Testbench
library IEEE;
use IEEE.std_logic_1164.all;

entity test_counter_4bit is
end test_counter_4bit;

architecture testbench  of test_counter_4bit is
   component counter_4bit
        port(
           clk,reset : in  bit;
           Q: out  bit_vector(3 downto 0));
  end component;
    
 signal clk:bit;
 signal reset:bit;
 signal Q:bit_vector(3 downto 0);

begin
  test: counter_4bit port map (
  clk=>clk,
  reset=>reset,
  Q=>Q);
    
process
  begin
-- This particular testbench counts up to 6
-- Reset assignment. Depending on the number you wish to count 
-- need to add appropriate number clk<='1'? reset<='0';  and clk<='0'; reset <='0';

    clk<='1'; reset<='1';
    wait for 10 ns;
    clk<='0'; reset<='1';
    wait for 10 ns;
    --1
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset <='0';
    wait for 10 ns;
    --2
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset<='0';
    wait for 10 ns;
    --3
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset<='0';
    wait for 10 ns;
        --4
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset<='0';
    wait for 10 ns;
    --5
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset<='0';
    wait for 10 ns;
     --6
    clk<='1'; reset<='0';
    wait for 10 ns;
    clk<='0'; reset<='0';
    wait for 10 ns;
    
   end process;
end testbench ;
