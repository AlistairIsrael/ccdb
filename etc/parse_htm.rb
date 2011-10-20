#!/usr/bin/env ruby

require 'nokogiri'

SOURCE_URL = ARGV[0] || 'http://www.iso.org/iso/country_codes/iso_3166_code_lists/country_names_and_code_elements.htm'

FILENAME = File.basename(SOURCE_URL)

unless File.exists?(FILENAME)
  
  WGET=`which wget`
  unless WGET
    puts 'Unable to find wget'
    exit 1
  end
  
  `wget #{SOURCE_URL}`
end

File.open(FILENAME) { |htm|
  doc = Nokogiri::HTML(htm)
  doc.xpath("//table[@id='tc_list']/tr").each {|tr|
    puts '----------'
    puts tr.at_xpath('td[3]').text()
    puts '----------'
    puts tr.at_xpath('td[1]').children()[1]
  }
}

#KTHXBAI
